import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IDiet } from '@/shared/model/diet.model';

import DietService from './diet.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Diet extends Vue {
  @Inject('dietService') private dietService: () => DietService;
  private removeId: number = null;

  public diets: IDiet[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllDiets();
  }

  public clear(): void {
    this.retrieveAllDiets();
  }

  public retrieveAllDiets(): void {
    this.isFetching = true;

    this.dietService()
      .retrieve()
      .then(
        res => {
          this.diets = res.data;
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
