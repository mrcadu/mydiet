import { IDiet } from '@/shared/model/diet.model';

export interface IUserDiet {
  id?: number;
  username?: string | null;
  password?: string | null;
  age?: number | null;
  genre?: string | null;
  biotype?: string | null;
  goal?: string | null;
  weight?: number | null;
  height?: number | null;
  neck?: number | null;
  waist?: number | null;
  hip?: number | null;
  bodyFat?: number | null;
  diet?: IDiet | null;
}

export class UserDiet implements IUserDiet {
  constructor(
    public id?: number,
    public username?: string | null,
    public password?: string | null,
    public age?: number | null,
    public genre?: string | null,
    public biotype?: string | null,
    public goal?: string | null,
    public weight?: number | null,
    public height?: number | null,
    public neck?: number | null,
    public waist?: number | null,
    public hip?: number | null,
    public bodyFat?: number | null,
    public diet?: IDiet | null
  ) {}
}
