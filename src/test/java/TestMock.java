import org.example.JSONMapper;
import org.example.JSONPlaceholder;
import org.example.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestMock {
    @Mock
    private JSONPlaceholder jsonPlaceholder;


    @Mock
    private HttpResponse<String> response;


    @Test
    public void testGetAllPosts() {
        // given
        JSONPlaceholder jsonPlaceholder = mock(JSONPlaceholder.class);
        ArrayList<Post> expectedList = new ArrayList<>();
        expectedList.add(new Post());
        when(jsonPlaceholder.getAllPosts())
                .thenReturn(expectedList);
        // when
        List<Post> actual = jsonPlaceholder.getAllPosts();
        // then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedList.size(), actual.size());
    }
    @Test
    public void testGetSinglePost() {
        // given
        JSONPlaceholder jsonPlaceholder = mock(JSONPlaceholder.class);

        String expected = "{\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "  }";
        Post expectedPost = JSONMapper.convertJSON(expected);
        when(jsonPlaceholder.getSinglePost(1)).thenReturn(expectedPost);

        // when
        Post actual = jsonPlaceholder.getSinglePost(1);
        // then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedPost, actual);
    }
}
