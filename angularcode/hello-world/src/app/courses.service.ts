

export class CoursesService{
    getCourses(){
        return ["course1", "course2", "course3"];
    }

    getCoursesCount(){
        return this.getCourses().length;
    }
}