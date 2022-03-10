import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IMeal } from '@/shared/model/meal.model';

import MealService from './meal.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Meal extends Vue {
  @Inject('mealService') private mealService: () => MealService;
  private removeId: number = null;

  public meals: IMeal[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllMeals();
  }

  public clear(): void {
    this.retrieveAllMeals();
  }

  public retrieveAllMeals(): void {
    this.isFetching = true;

    this.mealService()
      .retrieve()
      .then(
        res => {
          this.meals = res.data;
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
