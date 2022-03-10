import { IMeal } from '@/shared/model/meal.model';

export interface IFood {
  id?: number;
  name?: string | null;
  grams?: number | null;
  protein?: number | null;
  carbohydrate?: number | null;
  fat?: number | null;
  calories?: number | null;
  username?: string | null;
  meal?: IMeal | null;
}

export class Food implements IFood {
  constructor(
    public id?: number,
    public name?: string | null,
    public grams?: number | null,
    public protein?: number | null,
    public carbohydrate?: number | null,
    public fat?: number | null,
    public calories?: number | null,
    public username?: string | null,
    public meal?: IMeal | null
  ) {}
}
