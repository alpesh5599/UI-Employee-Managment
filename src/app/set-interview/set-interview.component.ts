import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SetInterviewService } from '../services/set-interview.service';

@Component({
  selector: 'app-set-interview',
  templateUrl: './set-interview.component.html',
  styleUrls: ['./set-interview.component.css']
})
export class SetInterviewComponent {

  constructor(private service:SetInterviewService){}

  interviewForm=new FormGroup({
    interviewerName:new FormControl('',[Validators.required]),
    interviewDateTime:new FormControl('',[Validators.required]),
    interviewOutCome:new FormControl(),
    feedback:new FormControl()
  })

  submitInterviewDetails(){
    this.service.setInterview(this.interviewForm.value).subscribe(res=>{
      console.log(res);
    })
  }
}