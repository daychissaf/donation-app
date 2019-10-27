import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectCrudComponent } from './project-crud.component';

describe('ProjectCrudComponent', () => {
  let component: ProjectCrudComponent;
  let fixture: ComponentFixture<ProjectCrudComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectCrudComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectCrudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
