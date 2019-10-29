import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssociationAddComponent } from './association-add.component';

describe('AssociationAddComponent', () => {
  let component: AssociationAddComponent;
  let fixture: ComponentFixture<AssociationAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssociationAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssociationAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
