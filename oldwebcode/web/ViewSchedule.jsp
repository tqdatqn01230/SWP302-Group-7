<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>SCHEDULE</title>
    <link rel='stylesheet'
        href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="css/style-home.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500&display=swap" rel="stylesheet">

    
    <link rel="stylesheet" href="fonts/icomoon/style.css">
  
    <link href='fullcalendar/packages/core/main.css' rel='stylesheet' />
    <link href='fullcalendar/packages/daygrid/main.css' rel='stylesheet' />
    
    
    <!-- Bootstrap CSS -->
    
    <!-- Style -->
    <link rel="stylesheet" href="css-schedule/style.css">

</head>

<body>
  <div data-component="navbar">
    <nav class="navbar p-0 fixed-top ">
        <div class="brand"><a class="navbar-brand px-1 logo" href="#">MEETUP <span>.</span></a>
            
            <div class="right-links float-right mr-4">
                <input type="text"/>
                <button type="submit" style=""><a href="search.html">Search</a></button>                    
                <a href="#" class="home"><i class="mr-3"></i></a>
                <div class="d-inline dropdown rounded-0 mx-3">
                    <a class="dropdown-toggle" id="tools" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false" href="#"><i class="fa fa-wrench" aria-hidden="true"></i></a>
                </div>
                <div class="d-inline dropdown mr-3">
                    <a class="dropdown-toggle" id="notifications" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false" href="#"><span>10</span><i class="fa fa-bell"></i></a>
                </div> <!-- /.dropdown -->
                <div class="d-inline dropdown mr-3">
                    <a class="dropdown-toggle" id="messages" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false" href="#"><i class="fa fa-envelope"></i></a>
                </div> <!-- /.dropdown -->
                <div class="d-inline dropdown">
                    <a class="dropdown-toggle" id="messages" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false" href="#">
                        <img src="img/avatar.png">
                    </a>
                </div> <!-- /.dropdown -->
            </div> <!-- /.right-links -->
        </div>
</div>
    <div data-component="sidebar">
        <div class="sidebar">
            <ul class="list-group flex-column d-inline-block first-menu">
                <li class="list-group-item pl-3 py-2">
                    <a href="home.html"><i class="fa fa-home" aria-hidden="true"><span
                          class="ml-2 align-middle">Home</span></i></a>
                  </li>
                  <li class="list-group-item pl-3 py-2">
                    <a href="profile.html"><i class="fa fa-user-o" aria-hidden="true"><span
                          class="ml-2 align-middle">Your Profile</span></i></a>
                  </li>
                  <li class="list-group-item pl-3 py-2">
                    <a href="event.html"><i class="fa fa-etsy" aria-hidden="true"><span
                          class="ml-2 align-middle">Event</span></i></a>
                  </li>
                  <li class="list-group-item pl-3 py-2">
                    <a href="schedule.html"><i class="fa fa-calendar" aria-hidden="true"><span
                          class="ml-2 align-middle">Schedule</span></i></a>
                  </li> <!-- /.list-group-item -->
            </ul> <!-- /.first-menu -->
        </div> <!-- /.sidebar -->
    </div>
    <div class="container">
        <div class="content">
            <div id='calendar'></div>
          </div>
    </div>

    <!-- partial -->
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script>
    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css'></script>
    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>

        
        
    
        <script src="js-schedule/jquery-3.3.1.min.js"></script>
        <script src="js-schedule/popper.min.js"></script>
        <script src="js-schedule/bootstrap.min.js"></script>
    
        <script src='fullcalendar/packages/core/main.js'></script>
        <script src='fullcalendar/packages/interaction/main.js'></script>
        <script src='fullcalendar/packages/daygrid/main.js'></script>
    
        <script>
          document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
    
        var calendar = new FullCalendar.Calendar(calendarEl, {
          plugins: [ 'interaction', 'dayGrid' ],
          defaultDate: '2021-10-07',
          editable: true,
          eventLimit: true, // allow "more" link when too many events
          events: [
            {
              title: 'All Day Event',
              start: '2021-10-01'
            },
            {
              title: 'Long Event',
              start: '2021-10-08',
              end: '2021-10-10'
            },
            {
              title: 'Conference',
              start: '2021-10-11',
              end: '2021-10-13'
            },
            {
              title: 'Meeting',
              start: '2021-10-12T10:30:00',
              end: '2021-10-12T12:30:00'
            },
            {
              title: 'Lunch',
              start: '2021-10-12T12:00:00'
            },
            {
              title: 'Meeting',
              start: '2021-10-12T14:30:00'
            },
            {
              title: 'Happy Hour',
              start: '2021-10-12T17:30:00'
            },
            {
              title: 'Dinner',
              start: '2021-10-12T20:00:00'
            },
          ]
        });
    
        calendar.render();
      });
    
        </script>
    
        <script src="js-schedule/main.js"></script>
</body>

</html>