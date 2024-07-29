import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SystemComponent } from "./system/system.component";
import { MappingComponent } from "./mapping/mapping.component";

const routes: Routes = [
  { path: 'systems', component: SystemComponent },
  { path: 'mappings', component: MappingComponent },
  { path: '', component: MappingComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
