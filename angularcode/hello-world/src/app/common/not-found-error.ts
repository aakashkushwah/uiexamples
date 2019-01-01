import { AppError } from './app-errors';

export class NotFoundError extends AppError{
    constructor(public originalError?: any){
        super();
    }
}