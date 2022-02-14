import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const UserDiet = () => import('@/entities/user-diet/user-diet.vue');
// prettier-ignore
const UserDietDetails = () => import('@/entities/user-diet/user-diet-details.vue');
// prettier-ignore
const Food = () => import('@/entities/food/food.vue');
// prettier-ignore
const FoodDetails = () => import('@/entities/food/food-details.vue');
// prettier-ignore
const Diet = () => import('@/entities/diet/diet.vue');
// prettier-ignore
const DietDetails = () => import('@/entities/diet/diet-details.vue');
// prettier-ignore
const Meal = () => import('@/entities/meal/meal.vue');
// prettier-ignore
const MealDetails = () => import('@/entities/meal/meal-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/user-diet',
    name: 'UserDiet',
    component: UserDiet,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/user-diet/:userDietId/view',
    name: 'UserDietView',
    component: UserDietDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/food',
    name: 'Food',
    component: Food,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/food/:foodId/view',
    name: 'FoodView',
    component: FoodDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/diet',
    name: 'Diet',
    component: Diet,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/diet/:dietId/view',
    name: 'DietView',
    component: DietDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/meal',
    name: 'Meal',
    component: Meal,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/meal/:mealId/view',
    name: 'MealView',
    component: MealDetails,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
