import axios from 'axios';

import { IStoreUserDataProcess } from '@/shared/model/store-user-data-process.model';

const baseApiUrl = 'api/store-user-data-processes';

export default class StoreUserDataProcessService {
  public find(id: number): Promise<IStoreUserDataProcess> {
    return new Promise<IStoreUserDataProcess>((resolve, reject) => {
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

  public create(entity: IStoreUserDataProcess): Promise<IStoreUserDataProcess> {
    return new Promise<IStoreUserDataProcess>((resolve, reject) => {
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
