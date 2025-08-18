import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { Secondcomp } from './app/secondcomp/secondcomp';
import { Logincom } from './app/logincom/logincom';
import { Thirdcomp } from './app/thirdcomp/thirdcomp';

bootstrapApplication(Thirdcomp, appConfig)
  .catch((err) => console.error(err));
