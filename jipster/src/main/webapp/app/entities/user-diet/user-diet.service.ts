import axios from 'axios';

import { IUserDiet } from '@/shared/model/user-diet.model';

const baseApiUrl = 'api/user-diets';

export default class UserDietService {
  public find(id: number): Promise<IUserDiet> {
    return new Promise<IUserDiet>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
