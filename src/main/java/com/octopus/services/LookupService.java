package com.octopus.services;

import com.google.common.base.Optional;
import com.octopus.domain.Environment;
import com.octopus.domain.Project;
import com.octopus.domain.Release;

import javax.validation.constraints.NotNull;

/**
 * Service for looking up entities in the Octopus Deploy REST API
 */
public interface LookupService {
    /**
     * Matches a project name to a project entity
     *
     * @param taskContext     The bamboo task context
     * @param environmentName The environment name
     * @return The environment object matching the environment name
     */
    Optional<Environment> getEnvironment(@NotNull LoggerService logger,
                                         @NotNull feign.Logger buildLogger,
                                         @NotNull String host,
                                         @NotNull String apiKey,
                                         @NotNull String environmentName,
                                         boolean verboseLogging);

    /**
     * Matches a project name to a project entity
     *
     * @param taskContext The bamboo task context
     * @param projectName The project name
     * @return The project object matching the project name
     */
    Optional<Project> getProject(@NotNull LoggerService logger,
                                 @NotNull feign.Logger buildLogger,
                                 @NotNull String host,
                                 @NotNull String apiKey,
                                 @NotNull String projectName,
                                 boolean verboseLogging);

    /**
     * Matches a project name to a project entity
     *
     * @param taskContext    The bamboo task context
     * @param releaseVersion The release version
     * @return The release object matching the release version
     */
    Optional<Release> getRelease(@NotNull LoggerService logger,
                                 @NotNull feign.Logger buildLogger,
                                 @NotNull String host,
                                 @NotNull String apiKey,
                                 @NotNull String releaseVersion,
                                 @NotNull Project project,
                                 boolean verboseLogging);

    /**
     * Matches a channel name to a channel entity
     *
     * @param taskContext The bamboo task context
     * @param projectID   The project id
     * @param channelName The channel name
     * @return The channel if, if one could be found
     */
    Optional<String> getChannel(@NotNull LoggerService logger,
                                @NotNull feign.Logger buildLogger,
                                @NotNull String host,
                                @NotNull String apiKey,
                                @NotNull Project project,
                                @NotNull String channelName,
                                boolean verboseLogging);

    /**
     * Gets the default channel entity for a project
     *
     * @param taskContext The bamboo task context
     * @param projectID   The project id
     * @return The channel if, if one could be found
     */
    Optional<String> getDefaultChannel(@NotNull LoggerService logger,
                                       @NotNull feign.Logger buildLogger,
                                       @NotNull String host,
                                       @NotNull String apiKey,
                                       @NotNull Project project,
                                       boolean verboseLogging);

    void populateSelectedPackages(@NotNull LoggerService logger,
                                  @NotNull feign.Logger buildLogger,
                                  @NotNull String host,
                                  @NotNull String apiKey,
                                  @NotNull Release release,
                                  @NotNull Project project,
                                  boolean verboseLogging);
}
