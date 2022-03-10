import { IFood } from '@/shared/model/food.model';
import { IDiet } from '@/shared/model/diet.model';

export interface IMeal {
  id?: number;
  name?: string | null;
  foods?: IFood[] | null;
  diet?: IDiet | null;
}

export class Meal implements IMeal {
  constructor(public id?: number, public name?: string | null, public foods?: IFood[] | null, public diet?: IDiet | null) {}
}
