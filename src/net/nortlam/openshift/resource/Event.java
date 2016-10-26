package net.nortlam.openshift.resource;

import java.io.Serializable;
import java.util.Objects;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import net.nortlam.openshift.JSON;

public class Event implements Serializable, JSON {
    
    public static final String VALUE_UNKNOWN = "Unknown";
    
    private String lastSeen;
    private String firstSeen;
    private int count;
    private String name;
    private Kind kind;
    private String subobject;
    private Type type; // Normal, Warning
    private Reason reason;
    private String source;
    private String message;

    public Event() {
        setUnknown();
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen != null ? lastSeen.trim() : VALUE_UNKNOWN;
    }

    public String getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(String firstSeen) {
        this.firstSeen = firstSeen != null ? firstSeen.trim() : VALUE_UNKNOWN;
    }

    public int getCount() {
        return count;
    }
    
    public void setCount(String value) {
        if(value != null) setCount(Integer.parseInt(value.trim()));
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name != null ? name.trim() : VALUE_UNKNOWN;
    }

    public Kind getKind() {
        return kind;
    }
    
    public void setKind(String value) {
        if(value != null) setKind(Kind.parse(value));
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public String getSubobject() {
        return subobject;
    }

    public void setSubobject(String subobject) {
        this.subobject = subobject != null ? subobject.trim() : VALUE_UNKNOWN;
    }

    public Type getType() {
        return type;
    }
    
    public void setType(String value) {
        if(value != null) setType(Type.parse(value));
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Reason getReason() {
        return reason;
    }
    
    public void setReason(String value) {
        System.out.printf(">>> setReason:%s\n", value);
        if(value != null) setReason(Reason.parse(value));
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source != null ? source.trim() : VALUE_UNKNOWN;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message != null ? message.trim() : VALUE_UNKNOWN;
    }
    
    public static Event parse(String line) {
        Event event = new Event();
        
        // LastSeen 0 - 10
        int[][] position = new int[][] {
            {0,10},   // LastSeen: 0 - 10
            {11, 22}, // FirstSeen: 11 - 22
            {23, 32}, // Count: 23 - 32
            {33, 51}, // Name: 33, 51
            {52, 61}, // Kind: 52, 61
            {62, 88}, // Subobject: 62 - 88
            {89, 98}, // Type: 89 - 98
            {99, 108}, // Reason: 99 - 108
            {109, 142}, // Source: 109 - 142
            {143, -1},
            };
        
        int length = 0;
        for(int i=0; i < position.length; i++) {
            length += position[i][1] - position[i][0];
            if(line.length() >= length) {
                switch(i) {
                    case 0: event.setLastSeen(line.substring(position[i][0], position[i][1])); break;
                    case 1: event.setFirstSeen(line.substring(position[i][0], position[i][1])); break;
                    case 2: event.setCount(line.substring(position[i][0], position[i][1])); break;
                    case 3: event.setName(line.substring(position[i][0], position[i][1])); break;
                    case 4: event.setKind(line.substring(position[i][0], position[i][1])); break;
                    case 5: event.setSubobject(line.substring(position[i][0], position[i][1])); break;
                    case 6: event.setType(line.substring(position[i][0], position[i][1])); break;
                    case 7: event.setReason(line.substring(position[i][0], position[i][1])); break;
                    case 8: event.setSource(line.substring(position[i][0], position[i][1])); break;
                    case 9: event.setMessage(line.substring(position[i][0], line.length()));
                }
            }
        }
        
        return event;
    }
    
    public void setUnknown() {
        setLastSeen(VALUE_UNKNOWN);
        setFirstSeen(VALUE_UNKNOWN);
        setCount(-1);
        setName(VALUE_UNKNOWN);
        setKind(Kind.UNKNOWN);
        setSubobject(VALUE_UNKNOWN);
        setType(Type.UNKNOWN);
        setReason(Reason.UNKNOWN);
        setSource(VALUE_UNKNOWN);
        setMessage(VALUE_UNKNOWN);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.lastSeen);
        hash = 59 * hash + Objects.hashCode(this.firstSeen);
        hash = 59 * hash + this.count;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.kind);
        hash = 59 * hash + Objects.hashCode(this.subobject);
        hash = 59 * hash + Objects.hashCode(this.type);
        hash = 59 * hash + Objects.hashCode(this.reason);
        hash = 59 * hash + Objects.hashCode(this.source);
        hash = 59 * hash + Objects.hashCode(this.message);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (this.count != other.count) {
            return false;
        }
        if (!Objects.equals(this.lastSeen, other.lastSeen)) {
            return false;
        }
        if (!Objects.equals(this.firstSeen, other.firstSeen)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.subobject, other.subobject)) {
            return false;
        }
        if (!Objects.equals(this.source, other.source)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (this.kind != other.kind) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (this.reason != other.reason) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return toJson().toString();
    }
    
    // JSON JSON JSON JSON JSON JSON JSON JSON JSON JSON JSON JSON JSON JSON JSON 
    //   JSON JSON JSON JSON JSON JSON JSON JSON JSON JSON JSON JSON JSON JSON JSON 

    @Override
    public JsonObject toJson() {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        
        if(this.lastSeen != null)
            builder.add("lastSeen", this.lastSeen);
        if(this.firstSeen != null)
            builder.add("firstSeen", this.firstSeen);
        if(this.count > 0)
            builder.add("count", this.count);
        if(this.name != null)
            builder.add("name", this.name);
        if(this.kind != null)
            builder.add("kind", this.kind.toString());
        if(this.subobject != null)
            builder.add("subobject", this.subobject);
        if(this.type != null)
            builder.add("type", this.type.toString());
        if(this.reason != null)
            builder.add("reason", this.reason.toString());
        if(this.source != null)
            builder.add("source", this.source);
        if(this.message != null)
            builder.add("message", this.message);
        
        return builder.build();
    }
}
