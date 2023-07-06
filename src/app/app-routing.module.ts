import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CandidateComponent } from './candidate/candidate.component';
import { GetCandidateComponent } from './get-candidate/get-candidate.component';
import { EditCandidateComponent } from './edit-candidate/edit-candidate.component';
import { SetInterviewComponent } from './set-interview/set-interview.component';
import { GetScheduledInterviewDetailsComponent } from './get-scheduled-interview-details/get-scheduled-interview-details.component';
import { UpdateInterviewDetailsComponent } from './update-interview-details/update-interview-details.component';
import { EmployeeModuleComponent } from './employee-module/employee-module.component';
import { ResumeUploaderComponent } from './resume-uploader/resume-uploader.component';

const routes: Routes = [
  { path:"", component:HomeComponent },
  { path:"candidate", component:CandidateComponent },
  { path:"getCandidate", component:GetCandidateComponent},
  { path:"editCandidate", component:EditCandidateComponent},
  { path:"setInterview", component:SetInterviewComponent },
  { path:"getInterviewDetails", component:GetScheduledInterviewDetailsComponent },
  { path:"updateInterviewDetails", component:UpdateInterviewDetailsComponent },
  { path:"employeeModule", component:EmployeeModuleComponent },
  { path:"file", component:ResumeUploaderComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
