/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';

import UserDietService from '@/entities/user-diet/user-diet.service';
import { UserDiet } from '@/shared/model/user-diet.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('UserDiet Service', () => {
    let service: UserDietService;
    let elemDefault;

    beforeEach(() => {
      service = new UserDietService();
      elemDefault = new UserDiet(0, 'AAAAAAA', 'AAAAAAA', 0, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 0, 0, 0, 0, 0, 0);
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign({}, elemDefault);
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of UserDiet', async () => {
        const returnedFromService = Object.assign(
          {
            username: 'BBBBBB',
            password: 'BBBBBB',
            age: 1,
            genre: 'BBBBBB',
            biotype: 'BBBBBB',
            goal: 'BBBBBB',
            weight: 1,
            height: 1,
            neck: 1,
            waist: 1,
            hip: 1,
            bodyFat: 1,
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of UserDiet', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
