import { NgModule, forwardRef } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from "@angular/common/http";
import { FormsModule, NG_VALUE_ACCESSOR, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from "@angular/material/button";
import { MatIconModule } from "@angular/material/icon";
import { MatMenuModule } from '@angular/material/menu';
import { MatTooltipModule } from '@angular/material/tooltip';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CandidateComponent } from './candidate/candidate.component';
import { EditCandidateComponent } from './edit-candidate/edit-candidate.component';
import { EmployeeModuleComponent } from './employee-module/employee-module.component';
import { GetCandidateComponent } from './get-candidate/get-candidate.component';
import { GetScheduledInterviewDetailsComponent } from './get-scheduled-interview-details/get-scheduled-interview-details.component';
import { HomeComponent } from './home/home.component';
import { ResumeUploaderComponent } from './resume-uploader/resume-uploader.component';
import { SetInterviewComponent } from './set-interview/set-interview.component';
import { UpdateInterviewDetailsComponent } from './update-interview-details/update-interview-details.component';
import { MatSnackBarModule} from '@angular/material/snack-bar';

@NgModule({
  declarations: [
    AppComponent,
    CandidateComponent,
    HomeComponent,
    GetCandidateComponent,
    EditCandidateComponent,
    SetInterviewComponent,
    GetScheduledInterviewDetailsComponent,
    UpdateInterviewDetailsComponent,
    EmployeeModuleComponent,
    ResumeUploaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatIconModule,
    MatMenuModule,
    MatTooltipModule,
    MatButtonModule,
    MatSnackBarModule

  ],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => CandidateComponent),
      multi: true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
