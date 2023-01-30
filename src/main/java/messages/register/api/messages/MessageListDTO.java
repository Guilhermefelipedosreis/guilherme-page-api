package messages.register.api.messages;

public record MessageListDTO(Long id, String name, String email, String phone, String content) {
   
    public MessageListDTO(Message message) {
        this(message.getId(), message.getName(), message.getEmail(), message.getPhone(), message.getContent());
    }

}
