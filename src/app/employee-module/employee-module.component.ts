import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-employee-module',
  templateUrl: './employee-module.component.html',
  styleUrls: ['./employee-module.component.css']
})
export class EmployeeModuleComponent {

  constructor(){}

  empForm=new FormGroup({
    employeeName:new FormControl(),
    employeeDOB:new FormControl(),
    employeeEmail:new FormControl(),
    employeePhoneNo:new FormControl(),
    interviewStatus:new FormControl(['']),
    joiningDate:new FormControl(),
    aadhdarCard:new FormControl(),

    address:new FormGroup({
      houseNo:new FormControl(),
      streetName:new FormControl(),
      areaName:new FormControl(),
      city:new FormControl(),
      state:new FormControl(),
      pinCode:new FormControl()
    }),

    documents:new FormGroup({
      marksheet:new FormControl(),
      certification:new FormControl(),
      experienceLetter:new FormControl()
    })

  })

  submitEmpData(){
    console.log(this.empForm.value);
  }

}