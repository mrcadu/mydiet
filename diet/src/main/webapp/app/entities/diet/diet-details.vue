<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="diet">
        <h2 class="jh-entity-heading" data-cy="dietDetailsHeading">
          <span v-text="$t('dietApp.diet.detail.title')">Diet</span> {{ diet.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('dietApp.diet.basalMetabolicRate')">Basal Metabolic Rate</span>
          </dt>
          <dd>
            <span>{{ diet.basalMetabolicRate }}</span>
          </dd>
          <dt>
            <span v-text="$t('dietApp.diet.caloriesGoal')">Calories Goal</span>
          </dt>
          <dd>
            <span>{{ diet.caloriesGoal }}</span>
          </dd>
          <dt>
            <span v-text="$t('dietApp.diet.protein')">Protein</span>
          </dt>
          <dd>
            <span>{{ diet.protein }}</span>
          </dd>
          <dt>
            <span v-text="$t('dietApp.diet.carbohydrate')">Carbohydrate</span>
          </dt>
          <dd>
            <span>{{ diet.carbohydrate }}</span>
          </dd>
          <dt>
            <span v-text="$t('dietApp.diet.fat')">Fat</span>
          </dt>
          <dd>
            <span>{{ diet.fat }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./diet-details.component.ts"></script>
