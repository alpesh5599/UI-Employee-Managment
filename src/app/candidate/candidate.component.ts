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
    this.openPDF();
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
      alert("Candidate Registered...");
    })
  }

  
  onFileChange(event: any) {
    const a = event.target.files[0] ;

    if(a){
      this.file = a;
      console.log("==> "+this.file);
    }
  }

   openPDF() {
    
    let response = this.base64ToArrayBuffer("JVBERi0xLjQKJfbk/N8KMSAwIG9iago8PAovVHlwZSAvQ2F0YWxvZwovUGFnZXMgMiAwIFIKL01ldGFkYXRhIDMgMCBSCj4CmVuZG9iago0IDAgb2JqCjw8Cj4+CmVuZG9iagoyIDAgb2JqCjw8Ci9UeXBlIC9QYWdlcwovQ291bnQgMjMKL0tpZHMgWzUgMCBSIDYgMCBSIDcgMCBSXQoPgplbmRvYmoKMyAwIG9iago8PAovTGVuZ3RoIDAKL1R5cGUgL01ldGFkYXRhCi9TdWJ0eXBlIC9YTUwKPj4Kc3RyZWFtDQoNCmVuZHN0cmVhbQplbmRvYmoKNSAw");
    let file = new Blob([response], { type: 'application/pdf' });            
    var fileURL = URL.createObjectURL(file);
    window.open(fileURL);
    
  }
  base64ToArrayBuffer(base64: string) {
    var binary_string =  window.atob(base64);
      var len = binary_string.length;
      var bytes = new Uint8Array( len );
      for (var i = 0; i < len; i++)        {
          bytes[i] = binary_string.charCodeAt(i);
      }
      return bytes.buffer;
  }
}