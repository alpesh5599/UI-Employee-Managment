import { Component, OnInit, forwardRef } from '@angular/core';
import { FormControl, FormGroup, NG_VALUE_ACCESSOR, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CandidateService } from '../services/candidate.service';
import { HttpResponse, HttpStatusCode } from '@angular/common/http';
import { CandidateModel } from '../CandidateModel';

@Component({
  selector: 'app-candidate',
  templateUrl: './candidate.component.html',
  styleUrls: ['./candidate.component.css']
})
export class CandidateComponent implements OnInit {

  candidateForm:any = FormGroup;
  fileName = '';
  
  file!:Blob;
  candidate =  new CandidateModel();

  constructor(private candidateService: CandidateService, private router: Router, private _snackBar: MatSnackBar) { }
  
  ngOnInit(): void {
    this.candidateForm = new FormGroup({
      applyingPosition: new FormControl('', [Validators.required]),
      candidateFirstName: new FormControl('', [Validators.required]),
      candidateLastName: new FormControl('', [Validators.required]),
      candidateEmail: new FormControl('', [Validators.required, Validators.email]),
      candidatePhoneNo: new FormControl('', [Validators.required]),
      candidateSkills: new FormControl('', [Validators.required]),
      joiningAvailability: new FormControl('', [Validators.required]),
      comments: new FormControl(),
      file: new FormControl()
    })
  }

  submitDetails() {
    
    const formValue = this.candidateForm.value;

    if(formValue && this.candidate){
      this.candidate.firstName = formValue.candidateFirstName;
      this.candidate.position = formValue.applyingPosition;
      this.candidate.lastName = formValue.candidateLastName;
      this.candidate.email = formValue.candidateEmail;
      this.candidate.contact = formValue.candidatePhoneNo;
      this.candidate.skills = formValue.candidateSkills;
      this.candidate.joining = formValue.joiningAvailability;
      this.candidate.fileName = this.file.name;
      this.candidate.comments = formValue.comments;
    }
    this.candidateService.saveCandidateData(this.candidate, this.file).subscribe((res:HttpResponse<any>) => {
       if (res.status == HttpStatusCode.Created) {
        
       }
    })
  }

  
  onFileChange(event: any) {
    const a = event.target.files[0] ;

    if(a){
      this.file = a;
      console.log("==> "+this.file);
    }
  }
}