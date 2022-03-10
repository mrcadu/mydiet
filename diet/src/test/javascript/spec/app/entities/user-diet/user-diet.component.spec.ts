/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import UserDietComponent from '@/entities/user-diet/user-diet.vue';
import UserDietClass from '@/entities/user-diet/user-diet.component';
import UserDietService from '@/entities/user-diet/user-diet.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('UserDiet Management Component', () => {
    let wrapper: Wrapper<UserDietClass>;
    let comp: UserDietClass;
    let userDietServiceStub: SinonStubbedInstance<UserDietService>;

    beforeEach(() => {
      userDietServiceStub = sinon.createStubInstance<UserDietService>(UserDietService);
      userDietServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<UserDietClass>(UserDietComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          userDietService: () => userDietServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      userDietServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllUserDiets();
      await comp.$nextTick();

      // THEN
      expect(userDietServiceStub.retrieve.called).toBeTruthy();
      expect(comp.userDiets[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
