import { Component, Vue, Inject } from 'vue-property-decorator';

import { IMeal } from '@/shared/model/meal.model';
import MealService from './meal.service';

@Component
export default class MealDetails extends Vue {
  @Inject('mealService') private mealService: () => MealService;
  public meal: IMeal = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.mealId) {
        vm.retrieveMeal(to.params.mealId);
      }
    });
  }

  public retrieveMeal(mealId) {
    this.mealService()
      .find(mealId)
      .then(res => {
        this.meal = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
