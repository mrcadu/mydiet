import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IUserDiet } from '@/shared/model/user-diet.model';

import UserDietService from './user-diet.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class UserDiet extends Vue {
  @Inject('userDietService') private userDietService: () => UserDietService;
  private removeId: number = null;

  public userDiets: IUserDiet[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllUserDiets();
  }

  public clear(): void {
    this.retrieveAllUserDiets();
  }

  public retrieveAllUserDiets(): void {
    this.isFetching = true;

    this.userDietService()
      .retrieve()
      .then(
        res => {
          this.userDiets = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
