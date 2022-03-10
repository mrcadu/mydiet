/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import UserDietDetailComponent from '@/entities/user-diet/user-diet-details.vue';
import UserDietClass from '@/entities/user-diet/user-diet-details.component';
import UserDietService from '@/entities/user-diet/user-diet.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('UserDiet Management Detail Component', () => {
    let wrapper: Wrapper<UserDietClass>;
    let comp: UserDietClass;
    let userDietServiceStub: SinonStubbedInstance<UserDietService>;

    beforeEach(() => {
      userDietServiceStub = sinon.createStubInstance<UserDietService>(UserDietService);

      wrapper = shallowMount<UserDietClass>(UserDietDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { userDietService: () => userDietServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundUserDiet = { id: 123 };
        userDietServiceStub.find.resolves(foundUserDiet);

        // WHEN
        comp.retrieveUserDiet(123);
        await comp.$nextTick();

        // THEN
        expect(comp.userDiet).toBe(foundUserDiet);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundUserDiet = { id: 123 };
        userDietServiceStub.find.resolves(foundUserDiet);

        // WHEN
        comp.beforeRouteEnter({ params: { userDietId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.userDiet).toBe(foundUserDiet);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
