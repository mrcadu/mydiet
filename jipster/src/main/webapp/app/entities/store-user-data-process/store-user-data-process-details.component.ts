import { Component, Vue, Inject } from 'vue-property-decorator';

import { IStoreUserDataProcess } from '@/shared/model/store-user-data-process.model';
import StoreUserDataProcessService from './store-user-data-process.service';

@Component
export default class StoreUserDataProcessDetailsComponent extends Vue {
  @Inject('storeUserDataProcessService') private storeUserDataProcessService: () => StoreUserDataProcessService;
  public storeUserDataProcess: IStoreUserDataProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveStoreUserDataProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveStoreUserDataProcess(storeUserDataProcessId) {
    this.isFetching = true;
    this.storeUserDataProcessService()
      .find(storeUserDataProcessId)
      .then(
        res => {
          this.storeUserDataProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
