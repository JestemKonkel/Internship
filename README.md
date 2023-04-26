# Internship Task

Technology stack

    Java 17
    Spring Boot    
    Hibernate
    JPA, JDBC
    FreeMarker

Project structure

    entity - Model layer from MVC design. Basic unit of work (in this case - Posts)
    repository - a layer between app and database (Hibernate database works on /console)
    controller - a sharing information layer (main point of application)

From controller side is work in that way: 

    On the "/home" address there is displaying Posts. Their number is limited to 30 per page 
    (JPA repository inherits a methods which allows fetch data and separate them on objects called Page )
    To move between pages must be given a parameters which represent a concrete page (exact number of page)
    In the same way a sorting works. Parameter specifies how data should be display.
    All data is send by Model from springframework.ui library

From template side is work in that way:  
    
    There is one template called all.ftlh. Contains whole look of app. 
    Data is display by "list" marker which understand a Model received from API. Its operation can be described as a loop.
    By default is fetching a first page. Moving between is possible with two buttons which redirect to next or previous page 
    (prev is available only under condition that number of page isn't 1)
    Changing a way of sorting works like the same (redirecting to page with matching parameters)
    By default there isn't specify sorting method (returned is a posts in numercal order by id)