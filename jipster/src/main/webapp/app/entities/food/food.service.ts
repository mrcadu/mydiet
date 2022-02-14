import axios from 'axios';

import { IFood } from '@/shared/model/food.model';

const baseApiUrl = 'api/foods';

export default class FoodService {
  public find(id: number): Promise<IFood> {
    return new Promise<IFood>((resolve, reject) => {
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
