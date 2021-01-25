import { BrowserModule } from '@angular/platform-browser';
import {APP_INITIALIZER, NgModule} from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import {KeycloakAngularModule, KeycloakService} from 'keycloak-angular';
import {AuthGuard} from './guard/AuthGuard';
import {HttpClientModule} from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {ButtonModule} from 'primeng/button';
import { HeaderComponent } from './header/header.component';
import {MenubarModule} from 'primeng/menubar';
import { ItemListComponent } from './item-list/item-list.component';
import {ItemComponent} from './item-list/item/item.component';
import {CardModule} from 'primeng/card';
import { CardComponent } from './component/card/card.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ItemGalleryComponent } from './item-list/item-gallery/item-gallery.component';

function initializeKeycloak(keycloak: KeycloakService): () => Promise<boolean> {

  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080/auth',
        realm: 'grocery',
        clientId: 'shopping-web',
      },
      initOptions: {
        onLoad: 'check-sso',
        checkLoginIframe: true,
        // silentCheckSsoRedirectUri:
        //   window.location.origin + '/assets/silent-check-sso.html',
      },
    });
}

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    HeaderComponent,
    ItemListComponent,
    ItemComponent,
    CardComponent,
    NavbarComponent,
    ItemGalleryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    KeycloakAngularModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ButtonModule,
    MenubarModule,
    CardModule
  ],
  providers: [
    AuthGuard,
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService],
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
