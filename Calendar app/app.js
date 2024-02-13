window.onload = function (){
    generateCalendar();
};
//Kreiranje kalendara 
function generateCalendar(){

    const calendar = document.getElementById('calendar');
    const currentDate = new Date();
    const month = currentDate.getMonth();
    const year = currentDate.getFullYear();

    const firstDayofMonth = new Date(year, month, 1);
    const lastDayofMonth = new Date(year, month + 1, 0);

    const firstDayofWeek = firstDayofMonth.getDay();
    const totaldays = lastDayofMonth.getDate();

    for(let i = 0; i < firstDayofWeek; i++){
        let blankday = document.createElement("div")
        calendar.appendChild(blankday);
    }

    for(let day = 1; day <= totaldays; day++){

        let daySquare = document.createElement("div");
        daySquare.className = "calendar-day";
        daySquare.textContent = day;
        daySquare.id = `day-${day}`;
        calendar.appendChild(daySquare);
    }


}

function showAddTaskModal(){
    document.getElementById('addTaskModal').style.display = 'block';
}

function closeAddTaskModal(){
    document.getElementById('addTaskModal').style.display = 'none';
}
function deleteTask(taskElement){
    if(confirm("Jeste li sigurni da li cete obrisati ovaj događaj?")){
        taskElement.parentNode.removeChild(taskElement);
    }
}

function editTask(taskElement){
    const newTascDesc = prompt("Uredi događaj:", taskElement.textContent);
    if(newTascDesc !== null & newTascDesc.trim() !==""){
        taskElement.textContent = newTascDesc;
    }
}
function addTask(){
    const taskDate = new Date(document.getElementById('task-date').value)
    const taskDesc = document.getElementById('task-desc').value.trim();

    if(taskDesc && !isNaN(taskDate.getDate())){
        const calendarDays = document.getElementById('calendar').children;
        for(let i = 0; i < calendarDays.length; i++){
            const day = calendarDays[i];
            if(parseInt(day.textContent)=== taskDate.getDate()){
                const taskElement = document.createElement("div");
                taskElement.className = "task";
                taskElement.textContent = taskDesc;

                taskElement.addEventListener("contextmenu", function(event){

                    event.preventDefault();
                    deleteTask(taskElement)
                });
                taskElement.addEventListener('click', function(){
                    editTask(taskElement);
                });
                day.appendChild(taskElement)
                break;
            }
        }
        closeAddTaskModal();
    }else{
        alert("Unesite tačan datum događaja")
    }

}
