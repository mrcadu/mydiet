import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IFood } from '@/shared/model/food.model';

import FoodService from './food.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Food extends Vue {
  @Inject('foodService') private foodService: () => FoodService;
  private removeId: number = null;

  public foods: IFood[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllFoods();
  }

  public clear(): void {
    this.retrieveAllFoods();
  }

  public retrieveAllFoods(): void {
    this.isFetching = true;

    this.foodService()
      .retrieve()
      .then(
        res => {
          this.foods = res.data;
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
