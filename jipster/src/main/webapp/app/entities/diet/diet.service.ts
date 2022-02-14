import axios from 'axios';

import { IDiet } from '@/shared/model/diet.model';

const baseApiUrl = 'api/diets';

export default class DietService {
  public find(id: number): Promise<IDiet> {
    return new Promise<IDiet>((resolve, reject) => {
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
