import { IUserDiet } from '@/shared/model/user-diet.model';

export interface IStoreUserDataProcess {
  id?: number;
  processInstance?: any | null;
  userDiet?: IUserDiet | null;
}

export class StoreUserDataProcess implements IStoreUserDataProcess {
  constructor(public id?: number, public processInstance?: any | null, public userDiet?: IUserDiet | null) {}
}
