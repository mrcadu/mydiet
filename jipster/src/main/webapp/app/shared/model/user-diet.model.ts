export interface IUserDiet {
  id?: number;
  username?: string | null;
  password?: string | null;
}

export class UserDiet implements IUserDiet {
  constructor(public id?: number, public username?: string | null, public password?: string | null) {}
}
