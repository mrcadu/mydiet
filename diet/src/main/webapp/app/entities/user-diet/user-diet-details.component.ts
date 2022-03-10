import { Component, Vue, Inject } from 'vue-property-decorator';

import { IUserDiet } from '@/shared/model/user-diet.model';
import UserDietService from './user-diet.service';

@Component
export default class UserDietDetails extends Vue {
  @Inject('userDietService') private userDietService: () => UserDietService;
  public userDiet: IUserDiet = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.userDietId) {
        vm.retrieveUserDiet(to.params.userDietId);
      }
    });
  }

  public retrieveUserDiet(userDietId) {
    this.userDietService()
      .find(userDietId)
      .then(res => {
        this.userDiet = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
