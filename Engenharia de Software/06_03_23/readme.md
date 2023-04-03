# 17/02/23:  

## Base Text:  
> We see three critical differences between programming and software engineering: time, scale, and the trade-offs at play. On a software engineering project, engineers need to be more concerned with the passage of time and the eventual need for change. In a software engineering organization, we need to be more concerned about scale and efficiency, both for the software we produce as well as for the organization that is producing it. Finally, as software engineers, we are asked to make more complex decisions with higher-stakes outcomes, often based on imprecise estimates of time and growth.  

## 1. Differences:  
  Programing by itself, compared to software engineering, it's more of a standalone skill or tool that can be used to reach some objective, being a simple single-use configuration .bat script to run once in your machine, or an entire application or game alongside other tools as a software engineer.  
  The text highlights some of the differences between the "programing" tool or skill and the "software engineering" role / job.

## 2. Definition:  
  A Software Engineer is someone that is capable of designing a project, including it's development time, scale and cost, develop and implement, maintain, test and evaluate such project.   
  The proccess of developing a large scale software can be defined into 6 steps:  
   - **Requirements:** Defining the *functional*, *non-functional* and *domain* requirements.  
   - **Design:** Idealize the internal components, properties, interfaces, relationships and interactions of all the systems of the project.  
   - **Construction:** The development or implementation of the project.  
   - **Testing:** Validation of the software's capabilities and usability.  
   - **Analysis:** Validation of some of the software properties such as performance, robustness, and security.  
   - **Maintenance:** Providing cost-effective support after shipping the software product.  

The role of a Software Engineer or Software Engineering team, is to successfully implement those steps to create a software.

# 24/02/23:  

## Base Text:  
> Within Google, we sometimes say, “Software engineering is programming integrated over time.” Programming is certainly a significant part of software engineering: after all, programming is how you generate new software in the first place. If you accept this distinction, it also becomes clear that we might need to delineate between programming tasks (development) and software engineering tasks (development, modification, maintenance). The addition of time adds an important new dimension to programming. Cubes aren’t squares, distance isn’t velocity. Software engineering isn’t programming.  

## 1. What is Software Engineering? 
  Software Engineering can be defined as a group of skills and actions that are applicable to reach the objetive of creating a software. It relates to programing since the skill is often necessary by the Software Engineer to engineer the software.

## 2. What are "Requirements"?  
  ### 2.1. Functional:  
  These are the requirements that the end user specifically demands as basic facilities that the system should offer, they are indisputable to the project. If the software engineer or team fails to implement the functional requirements, the software is considerable incomplete or failed.  
  
  ### 2.2. Non-Functional:  
  These are basically the quality constraints that the system must satisfy according to the project contract. The priority or extent to which these factors are implemented varies from one project to other. They are also called non-behavioral requirements.  
    
  ### 2.3. Name 2 examples of Trade-Offs in Non-Funcional Requirements:  
   - **Flexibility vs. Simplicity**. Some systems need to have a lot of flexibility and expandability built into them because you know you’re starting with the kernel of an idea and it’s going to get bigger. Others simply require a straightforward implementation with repeated reminders of YAGNI (You Ain’t Gonna Need It).  
   - **Space vs. Time**. If time is of the essence then you’ll want to start pulling tricks like pre-computing possible values similar to what OLAP (Online analytical processing) cubes do. Ever wonder how you can report on billions of rows across a range of dimensions so quickly? The aggregations are precomputed so that by the time you ask, the data is ready for you (or very close). On the other hand, you may need to minimize space and can afford some time which means you’ll be looking at compression and normalization to minimize redundant storage.  

  
  
