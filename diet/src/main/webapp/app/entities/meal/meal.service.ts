import axios from 'axios';

import { IMeal } from '@/shared/model/meal.model';

const baseApiUrl = 'api/meals';

export default class MealService {
  public find(id: number): Promise<IMeal> {
    return new Promise<IMeal>((resolve, reject) => {
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
