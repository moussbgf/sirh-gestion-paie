package dev.paie.config.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SystemPropertyUtils;

import dev.paie.entite.Performance;
import dev.paie.repository.PerformanceRepository;

@Configuration
@Aspect
public class ControllerPerformanceAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerPerformanceAspect.class);
	
	@Autowired PerformanceRepository perfRepo;
	
	@Around("execution(* dev.paie.web.controller.*.*(..))")
	public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
		
		Performance perf = new Performance();
		
		String nomService = pjp.getSignature().toString();
		
		perf.setNomService(nomService);

		LOGGER.debug("Début d'exécution de la méthode " + nomService);
		
		perf.setDateHeure(LocalDateTime.now());
		
		Long debut = System.currentTimeMillis();

		Object resultat = pjp.proceed();
		
		Long fin = System.currentTimeMillis();
		
		LOGGER.debug("Fin d'exécution de la méthode");
		
		perf.setTempsExecution(fin - debut);
		
		perfRepo.save(perf);
		
		
		return resultat;

	}

}
