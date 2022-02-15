<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="storeUserDataProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="storeUserDataProcessDetailsHeading">
          <span v-text="$t('jipsterApp.storeUserDataProcess.detail.title')">StoreUserDataProcess</span> {{ storeUserDataProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="storeUserDataProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('jipsterApp.storeUserDataProcess.detail.title')">StoreUserDataProcess</span> #{{ storeUserDataProcess.id }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="storeUserDataProcess.userDiet">
              <h5 class="card-header">
                <span class="title"> User Diet #{{ storeUserDataProcess.userDiet.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('jipsterApp.storeUserDataProcess.username')">username</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="username"
                    id="user-diet-username"
                    data-cy="username"
                    v-model="storeUserDataProcess.userDiet.username"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('jipsterApp.storeUserDataProcess.password')">password</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="password"
                    id="user-diet-password"
                    data-cy="password"
                    v-model="storeUserDataProcess.userDiet.password"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('jipsterApp.storeUserDataProcess.age')">age</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="age"
                    id="user-diet-age"
                    data-cy="age"
                    v-model="storeUserDataProcess.userDiet.age"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('jipsterApp.storeUserDataProcess.genre')">genre</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="genre"
                    id="user-diet-genre"
                    data-cy="genre"
                    v-model="storeUserDataProcess.userDiet.genre"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('jipsterApp.storeUserDataProcess.biotype')">biotype</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="biotype"
                    id="user-diet-biotype"
                    data-cy="biotype"
                    v-model="storeUserDataProcess.userDiet.biotype"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('jipsterApp.storeUserDataProcess.goal')">goal</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="goal"
                    id="user-diet-goal"
                    data-cy="goal"
                    v-model="storeUserDataProcess.userDiet.goal"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('jipsterApp.storeUserDataProcess.weight')">weight</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="weight"
                    id="user-diet-weight"
                    data-cy="weight"
                    v-model="storeUserDataProcess.userDiet.weight"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('jipsterApp.storeUserDataProcess.height')">height</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="height"
                    id="user-diet-height"
                    data-cy="height"
                    v-model="storeUserDataProcess.userDiet.height"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('jipsterApp.storeUserDataProcess.neck')">neck</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="neck"
                    id="user-diet-neck"
                    data-cy="neck"
                    v-model="storeUserDataProcess.userDiet.neck"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('jipsterApp.storeUserDataProcess.waist')">waist</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="waist"
                    id="user-diet-waist"
                    data-cy="waist"
                    v-model="storeUserDataProcess.userDiet.waist"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('jipsterApp.storeUserDataProcess.hip')">hip</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="hip"
                    id="user-diet-hip"
                    data-cy="hip"
                    v-model="storeUserDataProcess.userDiet.hip"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('jipsterApp.storeUserDataProcess.bodyFat')">bodyFat</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="bodyFat"
                    id="user-diet-bodyFat"
                    data-cy="bodyFat"
                    v-model="storeUserDataProcess.userDiet.bodyFat"
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./store-user-data-process-details.component.ts"></script>
