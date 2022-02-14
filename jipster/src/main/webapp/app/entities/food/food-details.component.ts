import { Component, Vue, Inject } from 'vue-property-decorator';

import { IFood } from '@/shared/model/food.model';
import FoodService from './food.service';

@Component
export default class FoodDetails extends Vue {
  @Inject('foodService') private foodService: () => FoodService;
  public food: IFood = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.foodId) {
        vm.retrieveFood(to.params.foodId);
      }
    });
  }

  public retrieveFood(foodId) {
    this.foodService()
      .find(foodId)
      .then(res => {
        this.food = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
