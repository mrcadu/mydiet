import { IMeal } from '@/shared/model/meal.model';

export interface IDiet {
  id?: number;
  basalMetabolicRate?: number | null;
  caloriesGoal?: number | null;
  protein?: number | null;
  carbohydrate?: number | null;
  fat?: number | null;
  meals?: IMeal[] | null;
}

export class Diet implements IDiet {
  constructor(
    public id?: number,
    public basalMetabolicRate?: number | null,
    public caloriesGoal?: number | null,
    public protein?: number | null,
    public carbohydrate?: number | null,
    public fat?: number | null,
    public meals?: IMeal[] | null
  ) {}
}
