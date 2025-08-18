import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { Listcomp } from './app/listcomp/listcomp';
import { Condicomp } from './app/condicomp/condicomp';
import { Switchdemo } from './app/switchdemo/switchdemo';
import { Switchdemo2 } from './app/switchdemo2/switchdemo2';
import { Home } from './app/home/home';

bootstrapApplication(Home, appConfig)
  .catch((err) => console.error(err));
