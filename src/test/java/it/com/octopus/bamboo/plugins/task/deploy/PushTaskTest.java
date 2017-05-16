package it.com.octopus.bamboo.plugins.task.deploy;

import com.atlassian.bamboo.task.TaskException;
import com.atlassian.bamboo.task.TaskResult;
import com.atlassian.bamboo.task.TaskType;
import com.atlassian.plugins.osgi.test.AtlassianPluginsTestRunner;
import com.octopus.services.MockObjectService;
import com.octopus.services.impl.MockObjectServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.validation.constraints.NotNull;

import static com.atlassian.bamboo.task.TaskState.SUCCESS;

/**
 * Integration tests for the deployment task
 */
@RunWith(AtlassianPluginsTestRunner.class)
public class PushTaskTest {
    private static final MockObjectService MOCK_OBJECT_SERVICE = new MockObjectServiceImpl();
    private TaskType octopusDeployTask;

    public PushTaskTest(@NotNull final TaskType octopusDeployTask) {
        this.octopusDeployTask = octopusDeployTask;
    }

    @Test
    public void test1() throws TaskException {
        Assert.assertNotNull(octopusDeployTask);

        final TaskResult taskResult = octopusDeployTask.execute(MOCK_OBJECT_SERVICE.getTaskContext());

        Assert.assertTrue(taskResult.getTaskState() == SUCCESS);
    }

}