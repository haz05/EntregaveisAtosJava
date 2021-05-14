import { TestBed } from '@angular/core/testing';

import { Servico2Service } from './servico2.service';

describe('Servico2Service', () => {
  let service: Servico2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Servico2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
