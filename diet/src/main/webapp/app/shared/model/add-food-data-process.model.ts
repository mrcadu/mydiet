import { IFood } from '@/shared/model/food.model';

export interface IAddFoodDataProcess {
  id?: number;
  processInstance?: any | null;
  food?: IFood | null;
}

export class AddFoodDataProcess implements IAddFoodDataProcess {
  constructor(public id?: number, public processInstance?: any | null, public food?: IFood | null) {}
}
