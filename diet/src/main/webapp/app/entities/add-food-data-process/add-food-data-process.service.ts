import axios from 'axios';

import { IAddFoodDataProcess } from '@/shared/model/add-food-data-process.model';

const baseApiUrl = 'api/add-food-data-processes';

export default class AddFoodDataProcessService {
  public find(id: number): Promise<IAddFoodDataProcess> {
    return new Promise<IAddFoodDataProcess>((resolve, reject) => {
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

  public create(entity: IAddFoodDataProcess): Promise<IAddFoodDataProcess> {
    return new Promise<IAddFoodDataProcess>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
