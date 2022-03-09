import { Component, Vue, Inject } from 'vue-property-decorator';

import { IDiet } from '@/shared/model/diet.model';
import DietService from './diet.service';

@Component
export default class DietDetails extends Vue {
  @Inject('dietService') private dietService: () => DietService;
  public diet: IDiet = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.dietId) {
        vm.retrieveDiet(to.params.dietId);
      }
    });
  }

  public retrieveDiet(dietId) {
    this.dietService()
      .find(dietId)
      .then(res => {
        this.diet = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
