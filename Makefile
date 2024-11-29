DAY_ARG := $(filter-out generate run,$(MAKECMDGOALS))

# Génération d'un nouveau jour
generate:
	@if [ -z "$(DAY_ARG)" ]; then \
		echo "Utilisez make generate 03"; \
		exit 1; \
	fi
	
	# Création du fichier Java
	sed -e "s/XX/$(DAY_ARG)/g" src/main/java/DayXX.java > src/main/java/Day$(DAY_ARG).java
	
	# Création du fichier d'input
	touch src/main/resources/day$(DAY_ARG).txt
	
	@echo "Généré Day$(DAY_ARG).java et day$(DAY_ARG).txt"

run:
	java src/main/java/Day$(DAY_ARG).java

%:
	@: