import { ErrorHandler} from '@angular/core';

export class AKErrorHandler implements ErrorHandler{
    handleError(error: any): void {
        console.log(error);
        alert('An unexpected error occurred');
    }

}